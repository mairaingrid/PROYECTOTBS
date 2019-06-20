const mongoose = require("../connect");
const Schema = mongoose.Schema;
const usuarioSchema = Schema({
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
       require:['ingrese su contraseña'],
  },
  })

const usuario = mongoose.model("Usuario",usuarioSchema);

module.exports = usuario;
