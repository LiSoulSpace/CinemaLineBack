## Return

code int\
msg String \
data String (json)

## 登录

### /user/login

POST

```
username String
password String
```

```json
{
  "code": [
    0,
    1,
    2
  ],
  "msg": [
    "",
    "密码错误",
    "用户名不存在"
  ],
  "data": {
    "userId": 1123,
    "nickName": "",
    "avatar": "url"
  }
}

```

token (cookie)

### /user/whoami

GET

## 购票

### /film/getList

GET POST
["hot", "time", "score", "income"]
```json
{
  "sort": "hot",
  "tag": "",
  "area": "",
  "years": ""
}
```

```json
{
  "code": [
    0
  ],
  "msg": "",
  "data": [
    {
      "id": 5,
      "title": "",
      "score": 4,
      "filmImg": "url地址"
    }
  ]
}
```

### /film/{id}

GET

```json
{
  "code": 0,
  "msg": "",
  "data": {
    "title": "",
    "filmImg": "",
    "tags": [],
    "area": "",
    "duration": "",
    "years": "",
    "description": "",
    "score": 2.0,
    "income": 11111,
    "people": [
      {
        "personName": "",
        "personImg": ""
      }
    ],
    "comments": []
  }
}
```

### /cinema/getList

GET

```json
{
  "city": "",
  "id": 55
}
```

```json
{
  "code": 0,
  "msg": "",
  "data": [
    {
      "cinemaName": "",
      "cinemaAddr": "",
      "cinemaImg": "",
      "cost": ""
    }
  ]
}
```

### /cinema/{id}

GET

```json
{
  "code": 0,
  "msg": "",
  "data": {
    "cinemaName": "",
    "cinemaAddr": "",
    "cinemaTel": "",
    "service": ""
  }
}
```

### /show/getTimeList

**GET**

```json
{
  "filmId": "",
  "cinemaId": ""
}
```

```json
{
  "code": 0,
  "msg": "",
  "data": [
    {
      "showId": 1111,
      "showTime": "",
      "cost": 2.0,
      "room": ""
    }
  ]
}
```

### /buy/getSeat

*token*
**GET**

```json
{
  "filmId": 1,
  "cinemaId": 2,
  "showId": 3
}
```

0 有座位
1 有座位不能使用
2 有人使用
3 空白

```json
{
  "code": 1,
  "msg": "",
  "data": {
    "seatMsg": [
      []
    ]
  }
}
```

### /buy/getTicket

*token*

```json
{
  "userId": 12,
  "filmId": 112,
  "cinemaId": 11,
  "showId": 1,
  "col": [],
  "row": []
}
```

0 成功
1 失败

```json
{
  "code": 0,
  "msg": "",
  "data": {
    "orderId": 11111,
    "title": "",
    "filmImg": "",
    "duration": "",
    "room": "",
    "showTime": "",
    "col": [],
    "row": [],
    "cost": 2.0,
    "qrcode": "base64"
  }
}
```

