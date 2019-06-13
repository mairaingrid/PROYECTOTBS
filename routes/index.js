var express = require('express');
var USER = require('../database/users');
var router = express.Router();

/* GET home page. */
router.get('/', function(req, res, next) {
  res.status(200).json({
    msn:"Bienvenidos a la API,TBS"
  })
});

router.post('/user',(req, res) =>{
  var params = req.body;
  params["registerdate"] = new Date();
  var users = new USER(params);
  users.save().then(() => {
    res.status(200).json({
      msn:"usuario registrado con exito"
    });
  });
});


module.exports = router;
