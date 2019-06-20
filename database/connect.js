const mongoose = require('mongoose');

mongoose.connect("mongodb://172.29.0.2:27017/TBS",{

}).then(()=>{
    console.log('conexion exitosa');
}).catch((err)=>{
    console.log('error',err);
});



module.exports = mongoose;
