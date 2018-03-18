package userservice.service;

import org.springframework.stereotype.Service;

/**
 * Created by mujiang on 2018/3/16.
 */
@Service
public class UserMgmtServiceImpl implements UserMgmtService{

    @Override
    public String getUserInfo(String userid) {

        String output = "zhangsan-gray";
        return output;
    }


}
