package miu.waa.assigment2.service.impl;


import miu.ea.assigment3.entity.DTOs.UserDto;
import miu.ea.assigment3.entity.Userdata;
import miu.ea.assigment3.repository.UserRepo;
import miu.ea.assigment3.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    ModelMapper modelMapper;

//    @Override
//    public List<Userdata> findAll() {
//        return userRepo.findAll();
//    }
//
//    @Override
//    public Userdata findById(int id) {
//        return userRepo.findById(id);
//    }
//
//    @Override
//    public Userdata deleteById(int id) {
//        return userRepo.deleteById(id);
//    }
//
//    @Override
//    public void save(Userdata u) {
//        userRepo.save(u);
//    }
//
//    @Override
//    public void delete() {
//
//    }
//
//    @Override
//    public void update() {
//
//    }

    @Override
    public UserDto create(UserDto userDTO) {
        Userdata userdata = modelMapper.map(userDTO, Userdata.class);
        return modelMapper.map(userRepo.save(userdata), UserDto.class);
    }

    @Override
    public List<UserDto> getAll() {
        return userRepo.findAll().stream().map(u->modelMapper.map(u,UserDto.class)).collect(Collectors.toList());
    }

    @Override
    public UserDto find(int id) {
        return modelMapper.map(userRepo.findById(id),UserDto.class);
    }

    @Override
    public UserDto update(int id, UserDto userDto) {
        return modelMapper.map(userRepo.findById(id),UserDto.class);
    }

    @Override
    public UserDto delete(int id) {
        Userdata userdata = userRepo.findById(id).orElseThrow(() -> new RuntimeException("User not found!!!"));
        userRepo.delete(userdata);
        return modelMapper.map(userdata, UserDto.class);
    }
}
