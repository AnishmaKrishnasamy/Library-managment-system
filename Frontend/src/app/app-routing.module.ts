import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddBooksComponent } from './Pages/add-books/add-books.component';
import { AddCategoryComponent } from './Pages/add-category/add-category.component';
import { BooksComponent } from './Pages/books/books.component';
import { CategoryComponent } from './Pages/category/category.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { HomeComponent } from './home/home.component';
import { HomepageComponent } from './homepage/homepage.component';
import { NavBarComponent } from './nav-bar/nav-bar.component';

const routes: Routes = [
  { path: '', redirectTo: 'login', pathMatch: 'full' },
  {path:'category', component:CategoryComponent},
  {path:'add-category', component: AddCategoryComponent},
  {path:'books', component: BooksComponent},
  {path:'add-books', component:AddBooksComponent},
  {path:'login',component:LoginComponent},
  {path:'register',component:RegisterComponent},
  {path:'homepage',component:HomepageComponent},
  {path:'home',component:HomeComponent},
  {path:'navbar',component:NavBarComponent}


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
