package com.perry.controller;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.perry.model.ActivitiModel;
import com.perry.service.UserService;

import java.util.ArrayList;
import java.util.List;
/**
 * Description:
 * <>
 * @Params :
 * @Return :
 * @Author : Perry
 * @Date : 2018/5/30 0:55
 *
 */

@Controller
@RequestMapping("/index")
public class IndexController {
	
    @Autowired
    private UserService userService;
    @Autowired
    private RepositoryService repositoryService;

    @RequestMapping("/index")
    public String index(ModelMap modelMap) {
 

        List<ActivitiModel> modelList = new ArrayList<ActivitiModel>();
        try {
            List<Model> modelList1 = repositoryService.createModelQuery()
                    .list();
            if (modelList1 != null && modelList1.size() > 0) {
                for (Model model : modelList1) {
                    ActivitiModel activitiModel = new ActivitiModel();
                    activitiModel.setId(model.getId());
                    activitiModel.setCreateTime(model.getCreateTime());
                    activitiModel.setDescription(model.getMetaInfo());
                    activitiModel.setKey(model.getKey());
                    activitiModel.setLastUpdateTime(model
                            .getLastUpdateTime());
                    activitiModel.setName(model.getName());
                    activitiModel.setVersion(model.getVersion());
                    modelList.add(activitiModel);
                }
            }
        } catch (Exception e) {
            e.getStackTrace();
        }

        modelMap.put("userList", userService.getUserList());
        modelMap.put("activitiModels", modelList);
        return "index";
    }
}
