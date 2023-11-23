package com.example.demo.service.Impl;

import com.example.demo.entities.Tables;
import com.example.demo.entities.users;
import com.example.demo.repository.IusersRepository;
import com.example.demo.service.IUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public  class IUserImplService implements IUserService {
    private  final IusersRepository iusersRepository;

    public IUserImplService(IusersRepository iusersRepository) {
        this.iusersRepository = iusersRepository;
    }
@Override
@Transactional
    public users save(users user)  {
        return iusersRepository.save(user);
    }

    @Override
    public void delete(Long id) throws Exception {
        iusersRepository.deleteById(id);
    }

    public users findByEmail(String email)  {
        return iusersRepository.findByEmail(email);
    }
    public List<users> getAll()  {
        return iusersRepository.findAll();
    }


    @Override
    public users getById(Long id) throws Exception {
        return iusersRepository.findById(id).orElseThrow(()->new Exception("El usuario no existe"));
    }

    @Override
    public users findByEmailAndPassword(String email, String password) {
        return iusersRepository.findByEmailAndPassword(email, password);
    }
}
