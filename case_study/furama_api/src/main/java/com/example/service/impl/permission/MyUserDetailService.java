package com.example.service.impl.permission;

import org.springframework.stereotype.Service;

@Service
public class MyUserDetailService implements UserDetailsService {
/*    @Autowired
    private IUserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<IUserDto> userDtos = userRepository.findUserName(username);

        if (userDtos.isEmpty()){
            throw new UsernameNotFoundException("User Name: "+ username + "Not Found");
        }
        UserDto user=new UserDto(userDtos.get(0));

        return new MyUserDetail(user);*/
//}
}
