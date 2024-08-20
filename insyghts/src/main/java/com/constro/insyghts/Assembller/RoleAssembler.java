package com.constro.insyghts.Assembller;
import com.constro.insyghts.Enum.RoleEnum;
import com.constro.insyghts.Dto.RoleDto;
import com.constro.insyghts.Entity.Role;
import org.springframework.stereotype.Component;

@Component
public class RoleAssembler {

    public RoleDto toDto(Role role) {
        RoleDto roleDTO = new RoleDto();
        roleDTO.setId(role.getId());
        roleDTO.setName(role.getName()); // Convert RoleName to String
        return roleDTO;
    }

    public Role toEntity(RoleDto roleDto) {
        Role role = new Role();
        role.setName(String.valueOf(RoleEnum.valueOf(roleDto.getName()))); // Convert String back to RoleName enum
        return role;
    }
}
