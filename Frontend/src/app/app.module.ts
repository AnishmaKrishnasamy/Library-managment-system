import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavBarComponent } from './nav-bar/nav-bar.component';
import { CategoryComponent } from './Pages/category/category.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { Ng2SearchPipeModule } from 'ng2-search-filter';
import { AddCategoryComponent } from './Pages/add-category/add-category.component';
import { BooksComponent } from './Pages/books/books.component';
import { AddBooksComponent } from './Pages/add-books/add-books.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { HomepageComponent } from './homepage/homepage.component';
import { HomeComponent } from './home/home.component';

@NgModule({
  declarations: [
    AppComponent,
    NavBarComponent,
    CategoryComponent,
    AddCategoryComponent,
    BooksComponent,
    AddBooksComponent,
    LoginComponent,
    RegisterComponent,
    HomepageComponent,
    HomeComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule, Ng2SearchPipeModule,
    HttpClientModule, ReactiveFormsModule, FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
