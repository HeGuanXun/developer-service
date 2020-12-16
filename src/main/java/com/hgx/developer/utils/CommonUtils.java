//package com.hgx.developer.utils;
//
//import com.hgx.developer.model.SetUser;
////import com.hgx.invoicing.security.JwtTokenUtils;
//import com.hgx.developer.service.SetUserService;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.security.authentication.AuthenticationManager;
//
//import javax.servlet.http.HttpServletRequest;
//
//public class CommonUtils {
//    private final static Logger LOG = LoggerFactory.getLogger(CommonUtils.class);
// /*   @Autowired
//    private SetUserService setUserService;
//
//    public   SetUser currentUser;
//
//    private static volatile CommonUtils commonUtils;
//
//    public SetUser getCurrentUser(String userName) {
//        if (currentUser==null){
//            SetUser setUser = new SetUser(userName);
//            if (setUserService==null){
//                setUserService = SpringUtil.getBean(SetUserService.class);
//            }
//            currentUser = setUserService.find(setUser);
//        }
//        return currentUser;
//    }
//
//    public SetUser getCurrentUser(HttpServletRequest request) {
////        String token = JwtTokenUtils.getToken(request);
////        String username = JwtTokenUtils.getUsernameFromToken(token);
//        return this.getCurrentUser("huamulan");
//    }
//*/
////    public static CommonUtils newInstance(){
////        if (commonUtils==null){
////            synchronized(CommonUtils.class){
////                if (commonUtils==null){
////                    commonUtils = new CommonUtils();
////                }
////            }
////        }
////        return commonUtils;
////    }
//
//}
