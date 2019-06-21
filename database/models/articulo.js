const mongoose = require("../connect");
const Schema = mongoose.Schema;
const articuloSchema = Schema({

  name: {
    type: String,
    required: [true, 'Ingrese el nombre del articulo'],
  },
  Product_photography:String,
  description:String,
  price: Number,
  quantity:Number,
  phone:Number,
  category:String,
  estate:String,
  log:String,
  lat:String,
  fechaRegistro:{
    type: Date,
    default: Date.now()
  }

});

const articulo = mongoose.model("Articulo",articuloSchema);

module.exports = articulo;
