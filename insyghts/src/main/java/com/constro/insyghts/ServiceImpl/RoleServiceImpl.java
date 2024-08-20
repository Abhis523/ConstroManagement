package com.constro.insyghts.ServiceImpl;

import com.constro.insyghts.Assembller.RoleAssembler;
import com.constro.insyghts.Dto.RoleDto;
import com.constro.insyghts.Entity.Role;
import com.constro.insyghts.Repository.RoleRepository;
import com.constro.insyghts.Service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;

public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private RoleAssembler roleAssembler;

    @Override
    public RoleDto getRoleByName(String name) {
        Role role = roleRepository.findByName(name).orElseThrow(() -> new RuntimeException("Role not found"));
        return roleAssembler.toDto(role);
    }
}
