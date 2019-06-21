const mongoose = require("../connect");
const Schema = mongoose.Schema;
const USUARIOSCHEMA = Schema({
  name:{
       type: String,
       require:[true, 'ingrese su  nombre'],
  },

  lastname:{
           type:String,
           require:[true,'ingrese su apellido'],
  },

  email: {
      type:String,
      require: ['ingrese su  email'],

  },

  password: {
       type:String,
       require:['Su contraseña debe tener como minimo seis caracteres ,mayusculas, minusculas y carcteres numericos '],
  },
  registerDate: {
        type: Date,
        default: Date.now()

    },
  })

const usuario = mongoose.model("Usuario",USUARIOSCHEMA);

module.exports = {model:usuario, schema: USUARIOSCHEMA};
