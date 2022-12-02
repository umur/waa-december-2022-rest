package miu.waa.assigment2.repository;



import miu.ea.assigment3.entity.Userdata;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<Userdata,Integer> {

//    List<Userdata> findAll();
//    Userdata findById(int id);
//
//    Userdata deleteById(int id);
}
