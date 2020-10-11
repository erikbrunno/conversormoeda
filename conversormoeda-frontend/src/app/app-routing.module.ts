
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './views/home/home.component';
import { ConversorMoedaComponent } from './views/conversor-moeda/conversor-moeda.component';
import { ConversorMoedaAddComponent } from './components/conversor-moeda-add/conversor-moeda-add.component';

const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'conversor-moeda', component: ConversorMoedaComponent },
  { path: 'conversor-moeda/adicionar', component: ConversorMoedaAddComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
