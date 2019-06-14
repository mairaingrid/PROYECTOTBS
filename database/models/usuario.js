const mongoose = require("./connect");
const Schema = mongoose.Schema;
const usuarioSchema = Schema({
  name:{
       type: String,
       require:[true, 'debe poner un nombre'],
  },

  email: {
      type:String,
      require: ['debe poner email'],

  },

  password: String,
  fechaRegistro: {
    type: Date,
    default:Date.now()
  },

  sex     : String,
  address : String

})
/*  name        : String,
  email       : String,
  password    : String,
  registerdate: Date,
  sex         : String,
  address     : String
}*/
const usuario = mongoose.model("Usuario",usuarioSCHEMA);

module.exports = usuario;
