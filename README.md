# FinReportAnalyzer

* Cash account file is downloaded from portal.
* IRA file is exported from trade pro. 

# gain_loss_closed_position table

```
drop table gain_loss_closed_position;
use fidelity;
create table gain_loss_closed_position (
id INT AUTO_INCREMENT PRIMARY KEY,
account VARCHAR(255) NOT NULL,
symbol VARCHAR(255) NOT NULL,
short_term DOUBLE NOT NULL,
long_term DOUBLE NOT NULL,
security_description VARCHAR(255) NOT NULL,
quantity INT NOT NULL,
date_acquired DATE,
date_sold DATE,
proceeds DOUBLE NOT NULL,
cost_basis DOUBLE NOT NULL,
sold_price_per_stock DOUBLE NOT NULL,
bought_price_per_stock DOUBLE NOT NULL,
wash_sale boolean DEFAULT false NOT NULL,
hash_code VARCHAR(255) NOT NULL,
init_processing_date DATE NOT NULL,
last_updated DATE NOT NULL
);
```

It ingests the data from Realized_Gain_Loss_Account_xxxxx.csv file.



## Queries

### Check how much each stock make (gain/loss)
```
SELECT symbol, SUM(short_term) FROM fidelity.gain_loss_closed_position
group by symbol;
```

### Check total gain or loss
```
select sum(short_term) from fidelity.gain_loss_closed_position
where account = '';
```

### Check perticular stock gain and loss

* Check how many transactions
 
```
SELECT count(*) FROM fidelity.gain_loss_closed_position
where symbol like '%BAC%'
```

This shows `19`.

```
SELECT sum(short_term) FROM fidelity.gain_loss_closed_position
where symbol like '%BAC%'
```

Shows `-237.249`

To see all the transactions about this stock and analyze the issue, check the folloiwng, 

```
SELECT * FROM fidelity.gain_loss_closed_position
where symbol like '%BAC%';
```

### Daily gain or loss

Since we have a proceeds date, so we can sum the amounts in the gains for certain day, for example for the current day.

```
SELECT sum(short_term) FROM fidelity.gain_loss_closed_position
where account = 'Account_X85490199' 
and date_sold = current_date()
order by date_sold desc
```

### Check loss events

Two queries

```
select * from fidelity.gain_loss_closed_position
where short_term < 0
order by short_term asc
```

```
select * from fidelity.gain_loss_closed_position
where short_term < 0
order by symbol
```

# watch_list