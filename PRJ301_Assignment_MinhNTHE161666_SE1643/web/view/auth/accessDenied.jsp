

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Access Denied!</title>
        <style>
            .content{
                width: 300px;
                margin: 10em auto;
                border: 1px solid #ccc;
                border-radius: 9px;
                padding: 15px;
                text-align: center;
                
            }
            .content a{
                text-decoration: none;
            }
            button{
                border: 1px solid #ccc;
                border-radius: 9px;
                padding: 2px 10px;
                animation: load 0.8s linear infinite;
            }
            button:hover{
                animation: loadHover 2.5s linear infinite;
            }
            @keyframes load{
                0%{
                    width: 50%;
                }
                100%{
                    width: 100%;
                }
            }
            @keyframes loadHover{
                0%{
                    width: 50%;
                    color: white;
                    background-color: red;
                }
                100%{
                    width: 100%;
                    color: white;
                    background-color: red;
                }
            }
        </style>
            
    </head>
    <body>
        <div class="content">
            <h2>Warning: Access denied!</h2>
            <button onclick="Login();">> Click here to login</a</button>
        </div>
        <script>
            function Login(){
                window.location = "login";
            }
        </script>
    </body>
</html>
