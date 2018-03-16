package vehicleservice.service;

import org.springframework.stereotype.Service;

/**
 * Created by mujiang on 2018/3/16.
 */
@Service
public class VehicleMgmtServiceImpl implements VehicleMgmtService{

    @Override
    public String getCarInfo(String carid) {

        String output = "BMW";
        return output;
    }


}
