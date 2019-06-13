var express = require('express');
var router  = express.Router();
const bcrypt = require("bcrypt");

const Usuario = require('../../database/models/usuario');

/*GET Usuario*/

router.get('/',function (req, res, next) {

  Usuario.find().exec().then(docs => {
    if(docs.length == 0) {
      res.json({
          message: "No existen usuarios en la base de datos"
      })
    } else{
      res.json(docs);
    }
  }).catch(err => {
     res.json({
       error: err
     });
  })
});

router.post('/', function (req, res, next){

   const datos = {
     name:req.body.name,
     email :req.body.email,
     sex   :req.body.sex,
     address:req.body.address,
};
bcrypt.hash(req.body.password, 10, (err, hash ) => {
  if (err){
     return res.status(500).json({
       error:err
     });
  } else {
     datos.password = hash;
     var modelUsuario = new Usuario(datos);
     modelUsuario.save().then(result => {
       res.json({
         msn:"Usuario insertado a la bd"
       });
     })
     .catch(err => {
         res.status(500).json({
           error:err
       })
    });
   }
 });
});

router.patch('/:id', function (req, res, next){
  let idUsuario = req.params.id;
  const datos = {};

  Objet.keys(req.body).forEach((key) => {
    datos[key] = req.body[key];
  });

  console.log(datos);
  Usuario.findByIdAndUpdate(idUsuario, datos)
        .then(result => {
             res.json({
                 msn:"Datos actualizados"
             });
        }).catch(err => {
           res.status(500).json({
             error:err
           })
        });
});

router.delete('/:id', function (req, res, next) {
  let idUsuario = req.params.id;

  Usuario.findByIdAndUpdate(idUsuario).exec()
      .then(() => {
           res.json({
               msn:"Usuario eliminado"
           });
      }).catch(err => {
         res.status(500).json({
           error:err
         });
      });
});

module.exports = router;
