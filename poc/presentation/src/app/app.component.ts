import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'presentation';
  var mysql = require('mysql');

  var connection = mysql.createConnection(
    {
      host:'localhost',
      user: "admin",
      database: "project",
      password: "mypassword", // sensitive
      multipleStatements: true
    });

  connection.connect();
}
