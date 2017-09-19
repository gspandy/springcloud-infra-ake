package service.controler;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mongodb.WriteResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.dao.UserDao;
import service.entity.ResponseDiscription;
import service.entity.User;
import service.util.TokenUtil;

import java.util.Date;
import java.util.List;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

/**
 * Created by epcm on 2017/7/13.
 */


@RestController
public class UserMgmtController {

    @Autowired
    UserDao userDao;

    @Autowired
    MongoTemplate mongoTemplate;


    private final static String URI = "/v1/apps/{appkey}/service/user-service/users/{username}";

    @GetMapping(value= UserMgmtController.URI )
    public ResponseEntity getUser(@PathVariable String appkey,@PathVariable String username, @RequestHeader String token){

        //校验token是否有效
        if(! TokenUtil.checkToken(token))
            return new ResponseEntity( ResponseDiscription.InvalidToken, HttpStatus.UNAUTHORIZED);


        JSONObject responseObj = new JSONObject();
        JSONArray userArrayObj = new JSONArray();

        //去mongo查询
        List userList = userDao.findByUsernameAndAppkey(username,appkey);

        if(userList.size() == 0 )
            return new ResponseEntity(" Can not find user: "+ username, HttpStatus.NOT_FOUND);

        for(Object user : userList){
            userArrayObj.add(JSON.toJSON(user));
        }

        responseObj.put("data",userArrayObj);
        responseObj.put("size",userArrayObj.size());


        System.out.println("~~~~~~ get:   " + username);

        return new ResponseEntity(responseObj, HttpStatus.OK);

    }

    @PutMapping(value= UserMgmtController.URI )
    public ResponseEntity modifyUser(@PathVariable String appkey,@PathVariable String username, @RequestHeader String token, @RequestBody String requestBody){

        //校验token是否有效
        if( ! TokenUtil.checkToken(token) )
            return new ResponseEntity(ResponseDiscription.InvalidToken ,HttpStatus.UNAUTHORIZED);

        User user = JSONObject.parseObject(requestBody,User.class);


//        //查询用户是否存在
//        if(UserUtil.isUserExist(username,appkey))
//            return new ResponseEntity("User: "+ username+ " Exists!",HttpStatus.CONFLICT);


        long timestamp = new Date().getTime();
        user.setUsername(username);
//        user.setAppkey(appkey);
        user.setModified_at(timestamp);


        Update update = new Update().set("password",user.getPassword());
        WriteResult writeResult = mongoTemplate.updateFirst(query(where("username").is(username)),update,User.class);

        System.out.println("~~~~~~  put:   "+username);

        return new ResponseEntity(JSONObject.toJSONString(user), HttpStatus.OK);

    }








}
