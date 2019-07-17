var createError = require('http-errors');
var express = require('express');
var path = require('path');
var cookieParser = require('cookie-parser');
var logger = require('morgan');
var indexRouter = require('./routes/index');

const socketio = require('socket.io');
const mongoose = require('mongoose');

const http = require('http');


// initializing server and sockets
const app = express();
const server= http.createServer(app);
const io = socketio.listen(server);

// connection to the server
mongoose.connect('mongodb://172.17.0.1:27017/ApiTBS')
  .then(db => console.log('db connected'))
  .catch(err => console.log(err));

const usuarios = require('./routes/api/usuarios');
const imagenes = require('./routes/api/imagenes');
const sockets = require('./routes/api/sockets');
const productos = require('./routes/api/productos');
const mensajes = require('./routes/api/mensajes');
const citas = require('./routes/api/citas');


//var app = express();

// view engine setup
app.set('views', path.join(__dirname, 'views'));
app.set('view engine', 'jade');

app.use(logger('dev'));
app.use(express.json());
app.use(express.urlencoded({ extended: false }));
app.use(cookieParser());
app.use(express.static(path.join(__dirname, 'public')));

//app.use('/v1.0/api', indexRouter);
app.use('/api/usuarios', usuarios);
app.use('/api/imagenes', imagenes);
app.use('/api/sockets', sockets);
app.use('/api/productos', productos);
app.use('/api/mensajes', mensajes);
app.use('/api/citas', citas);

// catch 404 and forward to error handler
app.use(function(req, res, next) {
  next(createError(404));
});

// error handler
app.use(function(err, req, res, next) {
  // set locals, only providing error in development
  res.locals.message = err.message;
  res.locals.error = req.app.get('env') === 'development' ? err : {};

  // render the error page
  res.status(err.status || 500);
  res.render('error');
});



// sockets
require('./routes/api/sockets')(io);

//con este hice funcionar express

const port = 8000;
app.listen(port, () => {
  console.log("SERVIDOR CORRIENDO EN PUERTO "+port);

});
module.exports = app;
