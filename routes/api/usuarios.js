var express = require('express');
var router = express.Router();
const bcrypt = require("bcrypt");
const Usuario = require('../../database/models/usuario');
//const users = require('../database/users');
const USUARIOSCHEMA = Usuario.schema;
var valid = require("../../utils/valid");
/* GET Usuarioe. */
router.get('/', function (req, res, next) {

    Usuario.find().exec().then(docs => {
        if (docs.length == 0) {
            res.json({
                message: "No existen usuarios en la base de datos"
            })
        } else {
            res.json(docs);
        }
    }).catch(err => {
        res.json({
            error: err
        });
    })

});
router.post('/',async(req,res) => {
   var params = req.body;
   params["registerdate"]= new Date();
  if(!valid.checkParams(USUARIOSCHEMA, params)){
    res.status(300).json({
      msn:"parametros incorrectos"
    });
    return;
  }
  if(!valid.checkEmail(params.email)) {
    res.status(300).json({
    msn:"Email invalido"
  });
  return;
}
if(!valid.checkPassword(params.password)) {
  res.status(300).json({
  msn:"password invalido"
});
return;
}
  var usuario = new   USUARIO(params);
  var result = await usuario.save();
  res.status(200).json(result)
});


/*router.post('/', function (req, res, next) {

    const datos = {
        name: req.body.name,
        lastname: req.body.lastname,
        email: req.body.email,

    };
    bcrypt.hash(req.body.password, 10, (err, hash) => {
        if (err) {
            return res.status(500).json({
                error: err
            });
        } else {
            datos.password = hash;
            var modelUsuario = new Usuario(datos);
            modelUsuario.save().then(result => {
                    res.json({
                        message: "Usuario insertado en la bd"
                    });
                })
                .catch(err => {
                    res.status(500).json({
                        error: err
                    })
                });


        }
    });

});*/
 /*router.patch('/',(req,res) => {
   if (req.query.id == null) {
     res.status(300).json({
       msn:"error no existe id"
     });
     return;
   }
   var id = req.query.id;
   var params = req.body;
   Usuario.findByIdAndUpdate({_id: id}, params, (err,docs) => {
     res.status(200).json(docs);
   });
});*/

router.patch('/', function (req, res, next) {
    let idUsuario = req.query.id;
    const datos = {};

    Object.keys(req.body).forEach((key) => {
        datos[key] = req.body[key];
    });
    console.log(datos);
    Usuario.findByIdAndUpdate(idUsuario, datos).exec()
        .then(result => {
            res.json({
                message: "Datos actualizados"
            });
        }).catch(err => {
            res.status(500).json({
                error: err
            })
        });
});

router.delete("/",async(req,res) => {
//  var id = req.query.id;
  if(req.query.id == null){
    res.status(300).json({
      msn:"Error no existe el id"
    });
    return;
  }
  var r = await Usuario.remove({_id: req.query.id});
  res.status(300).json(r);
/*router.delete('/', function (req, res, next) {
    let idUsuario = req.params.id;

    Usuario.findByIdAndRemove(idUsuario).exec()
        .then(() => {
            res.json({
                message: "Usuario eliminado"
            });
        }).catch(err => {
            res.status(500).json({
                error: err
            });
        });

*/
});



module.exports = router;
