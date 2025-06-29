import { Routes } from '@angular/router';
import { authGuard } from './guards/auth.guard';
import { useRoleGuard } from './guards/userole.guard';
import { AuthService } from './services/auth.service';
import { AuthguadService } from './services/authguad.service';
import { AuthComponent } from './auth/auth.component';
import { AdminComponent } from './users/admin/admin.component';
import { ClientComponent } from './users/client/client.component';
import { HomeComponent } from './home/home.component';
import { WishlistComponent } from './layout/wishlist/wishlist.component';
import { CategoryComponent } from './layout/category/category.component';
import {CategoriesComponent} from './users/client/pages/categories/categories.component';
import { AvisComponent } from './layout/avis/avis.component';
import { UsercrudComponent } from './users/admin/usercrud/usercrud.component';
import { GamecrudComponent } from './users/admin/gamecrud/gamecrud.component';
import { AuthorComponent } from './layout/author/author.component';
import { PublisherComponent } from './layout/publisher/publisher.component';
import { PurchaseComponent } from './layout/purchase/purchase.component';
import { AuteurComponent } from './users/client/pages/auteur/auteur.component';
import { MainComponent } from './header/main/main.component';
import { EmptyComponent } from './header/empty/empty.component';

export const routes: Routes = [
  { path: 'auth', component: AuthComponent, canActivate: [authGuard] },
  { path: 'home', component: HomeComponent },
  {
    path: '',
    component: MainComponent,
    canActivate: [AuthguadService, useRoleGuard],
    data: { roles: ['client'] },
    children: [
      { path: '', redirectTo: 'client', pathMatch: 'full' },
      { path: 'client', component: ClientComponent },
      { path: 'auteur', component: AuteurComponent },
      { path: 'categorie', component: CategoriesComponent },
    //{ path: 'wishlist', component: WishlistComponent},
    //{ path: 'publisher', component: PublisherComponent},
    ],
  },

  {
    path: '',
    component: EmptyComponent,
    canActivate: [AuthguadService, useRoleGuard],
    data: { roles: ['administrateur'] },
    children: [
      { path: '', redirectTo: 'admin', pathMatch: 'full' },
      {
        path: 'admin',
        component: AdminComponent,
        children: [
          { path: 'users', component: UsercrudComponent },
          { path: 'games', component: GamecrudComponent },
          { path: 'author', component: AuthorComponent },
          { path: 'category', component: CategoryComponent },
          { path: 'publisher', component: PublisherComponent },
          { path: 'avis', component: AvisComponent },
          { path: 'purchase', component: PurchaseComponent },
        ],
      },
    ],
  },
  { path: '**', redirectTo: '' },
];
