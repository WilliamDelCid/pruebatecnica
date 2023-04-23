package com.pruebatecnica.springmvc.dao;
import com.pruebatecnica.springmvc.model.Usuarios;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UsuarioDAOI implements UsuarioDao{

    public UsuarioDAOI(DataSource dataSourse){
        this.jdbcTemplate = new JdbcTemplate(dataSourse);
    }

    private JdbcTemplate jdbcTemplate;

    @Override
    public int guardar(Usuarios usuarios) {
        String sql = "INSERT INTO \"usuarios\" (\"user\", \"password\",\"rol\") VALUES (?, ?,?) ";
        return jdbcTemplate.update(sql,usuarios.getUser(),usuarios.getPassword(),usuarios.getRol());
    }
    @Override
    public int actualizar(Usuarios usuarios) {
       String sql = "UPDATE \"usuarios\" SET \"user\" = ?, \"password\" = ?,\"rol\"=? WHERE \"idUser\" = ? ";
       return jdbcTemplate.update(sql,usuarios.getUser(),usuarios.getPassword(),usuarios.getRol(),usuarios.getIdUser());
    }
    @Override
    public Usuarios obtener(Integer id) {
        String sql = "SELECT * FROM \"usuarios\" WHERE \"idUser\"=" + id;
        ResultSetExtractor<Usuarios> extractor = new ResultSetExtractor<Usuarios>() {
            @Override
            public Usuarios extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                if (resultSet.next()){
                    String user = resultSet.getString("user");
                    String password = resultSet.getString("password");
                    String rol = resultSet.getString("rol");
                    return new Usuarios(id,user,password,rol);
                }
                return null;
            }
        };
        return jdbcTemplate.query(sql,extractor);
    }

    @Override
    public int eliminar(Integer id) {
        String sql = "DELETE FROM \"usuarios\" WHERE \"idUser\"="+id;
        return jdbcTemplate.update(sql);

    }

    @Override
    public List<Usuarios> list() {
        String sql = "SELECT * FROM \"usuarios\" ";
        RowMapper<Usuarios> rowMapper = new RowMapper<Usuarios>() {
            @Override
            public Usuarios mapRow(ResultSet resultSet, int i) throws SQLException {
                int id = resultSet.getInt("idUser");
                String user = resultSet.getString("user");
                String password = resultSet.getString("password");
                String rol = resultSet.getString("rol");
                return new Usuarios(id,user,password,rol);
            }
        };
        return jdbcTemplate.query(sql,rowMapper);

    }
    @Override
    public Usuarios obtenerUser(String name) {
        String sql = "SELECT * FROM \"usuarios\" WHERE \"user\"='" + name + "'";

        ResultSetExtractor<Usuarios> extractor = new ResultSetExtractor<Usuarios>() {
            @Override
            public Usuarios extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                if (resultSet.next()){
                    String user = resultSet.getString("user");
                    String password = resultSet.getString("password");
                    String rol = resultSet.getString("rol");
                    return new Usuarios(user,password,rol);
                }
                return null;
            }
        };
        return jdbcTemplate.query(sql,extractor);
    }
}
