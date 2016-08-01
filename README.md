###PREVIEW APPLICATION :
<https://protected-harbor-60953.herokuapp.com/app>
# company
Company App is used to perform CRUD(create, update, delete, get) operation on Company Entity. Back-End API's are exposed using spring MVC and Front End is created using angular JS

###Build  project :
```mvn clean install```

###Running project :
running project using jetty server at 8080 port

```mvn jetty:run```

at custom port

```mvn -Djetty.port=8888 jetty:run```

###Testing rest APIs:
1. create company (POST):

```curl -X POST -H "Content-type:application/json" -d '{
    "companyName": "Software company",
    "companyAddr": {
      "streetAddress": "flat 403",
      "city": "DELHI",
      "country": "INDIA",
      "pincode": 411028
    },
    "emailAddress": "himuk4u@gmail.com",
    "phoneNo": "910093091209830",
    "ownerNames": [
      "himanshu",
      "raman",
      "kajal",
      "akhansha"
    ]
}' http://localhost:8080/api/company```

2. get companies list (GET LIST):

```curl -X GET http://localhost:8080/api/company```

3. get company (GET):

```curl -X GET http://localhost:8080/api/company/1```

4. update company (PUT):

```curl -X PUT -H "Content-type:application/json" -d '{
    "companyName": "Technology First",
    "companyAddr": {
      "streetAddress": "flat 403",
      "city": "DELHI",
      "country": "INDIA",
      "pincode": 411028
    },
    "emailAddress": "abc@gmail.com",
    "phoneNo": "910093091209830",
    "ownerNames": [
      "himanshu",
      "raman",
      "kajal",
      "akhansha"
    ]
}' http://localhost:8080/api/company/1```

5. add owners to owner list (PUT):

```curl -X PUT http://localhost:8080/api/company/1/addowner/new-owner-name-here```

### Use client for doing CRUD operation:

1. go to below URL and follow the links:

<http://localhost:8080/app>



