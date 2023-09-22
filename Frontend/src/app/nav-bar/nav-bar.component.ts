import { Component, OnInit } from '@angular/core';
import { Category } from '../Interfaces/category';
import { CategoryService } from '../Services/category.service';

@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.css']
})
export class NavBarComponent implements OnInit {

  categories:Array<Category>=[];   
  searchText: string = "";

  constructor(private cs: CategoryService) { }

  ngOnInit(): void {
  }

  
  loadAllCategory(): void {
    this.cs.loadAllCategory().subscribe(result=> {
      this.categories = result;
    })    
  }

  
  search(searchText: string) {
      sessionStorage.setItem("search_item", searchText);
      window.location.reload();
  }

}
