

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
         <link rel="stylesheet" href="css/LoginCss.css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login now</title>
       
    </head>
    <body>
        <div class="login-box">
            <h2>Login now</h2>
            <form action="login" method="POST">
                <div class="user-box">
                    <input type="text" name="username" value=""/>
                         <label>Email</label>
                </div>
                
                 <div class="user-box">
                   <input type="password" name="password" value=""/>
                         <label>Password</label>
                </div>
                   
                        
                
                    <div class="noti">
                        
                            <p>${noti}</p>
                       </div>
                                          
                    <a href="">
                        <span></span>
                        <span></span>
                        <span></span>
                        <span></span>
                        <input style="background-color: rgba(0,0,0,.5); color: white;font-size: 1.5rem" type="submit" value="login"  /> 
                    </a>
                   <!--<div class="login-box">
  <h2>Login</h2>
  <form>
    <div class="user-box">
      <input type="text" name="" required="">
      <label>Username</label>
    </div>
    <div class="user-box">
      <input type="password" name="" required="">
      <label>Password</label>
    </div>
    <a href="#">
      <span></span>
      <span></span>
      <span></span>
      <span></span>
      Submit
    </a>
  </form>
</div>-->
                    

                
            </form> 
        </div>   
    </body>
</html>
