# make project's docker images by google jib
1、local install docker <br>
2、set HTTP_PROCY=http://127.0.0.1:1080 <br>
3、cd jib project path / && mvn clean compile jib:dockerBuild <br>
4、docker run -dit --name jib -p 8081:8081 xyz.itbest.demo/jib:0.0.1 <br>
5、docker logs -f jib <br>
6、access http://localhost:8081/ 