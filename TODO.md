# MVP TODO list

In VO class, use @Data and igonore all the setter, getter, and constructor.

```
@Service
public class CityService implements ICityService {

    @Autowired
    private JdbcTemplate jtm;

    @Override
    public List<City> findAll() {

        String sql = "SELECT * FROM cities";

        return jtm.query(sql, BeanPropertyRowMapper.newInstance(City.class));
    }

    @Override
    public City findById(Long id) {

        String sql = "SELECT * FROM cities WHERE id = ?";

        return jtm.queryForObject(sql, new Object[]{id},
                BeanPropertyRowMapper.newInstance(City.class));
    }
}
```