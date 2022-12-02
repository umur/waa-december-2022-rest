package miu.waa.assigment2.service;


import miu.ea.assigment3.entity.DTOs.UserDto;
import miu.ea.assigment3.entity.Userdata;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
//    List<Userdata> findAll();
//    Userdata findById(int id);
//
//    Userdata deleteById(int id);
//    public void save(Userdata u);
//    public void delete();
//
//    public void update();

    public UserDto create(UserDto userDto);

    public List<UserDto> getAll();

    UserDto find(int id);

    public UserDto update(int id,UserDto userDto);
    public UserDto delete(int id);

}
