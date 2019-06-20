var express = require('express');
var router = express.Router();
const bcrypt = require("bcrypt");
const Usuario = require('../../database/models/usuario');
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

router.post('/', function (req, res, next) {


    const datos = {
        name: req.body.name,
        lastname: req.body.lastname,
        email: req.body.email,
        //password: req.body.password,
        //telefono: req.body.telefono,
        //avatar: req.body.avatar,
        //tipo: req.body.tipo,
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

});

router.patch('/:id', function (req, res, next) {
    let idUsuario = req.params.id;
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

router.delete('/:id', function (req, res, next) {
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


});



module.exports = router;
