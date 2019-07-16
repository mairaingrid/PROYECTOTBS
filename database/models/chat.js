//const mongoose = require('mongoose');
const mongoose = require('../connect');
//const Schema = mongoose.Schema;
const { Schema } = mongoose;

const ChatSchema = new Schema({
  nick: String,
  msg: String,
  created: { type: Date, default: Date.now }
});

module.exports = mongoose.model('Chat', ChatSchema);
