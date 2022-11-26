import { NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { ContentModule } from "./components/content/content.module";
import { NotFoundComponent } from "./components/not-found/not-found.component";
import { LoginComponent } from "./pages/login/login.component";
import { RegisterComponent } from "./pages/register/register.component";

const routes : Routes = [
    {
        path : '',
        redirectTo : 'login',
        pathMatch : 'full'
    },
    {
        path : 'login',
        component : LoginComponent
    },
    {
        path : 'register',
        component : RegisterComponent
    },
    {
        path : 'dashboard',
        loadChildren : () => import('./pages/dashboard/dashboard.module').then(mod => mod.DashboardModule)
    },
    {
        path : 'profile',
        loadChildren : () => import('./pages/profile/profile.module').then(mod => mod.ProfiledModule)
    },
    {
        path : 'class-hdr',
        loadChildren : () => import('./pages/class-hdr/class-hdr.module').then(mod => mod.ClassHdrModule)
    },
    {
        path : 'users',
        loadChildren : () => import('./pages/user/user.module').then(mod => mod.UserModule)
    },
    {
        path : 'class-dtl',
        loadChildren : () => import('./pages/class-dtl/class-dtl.module').then(mod => mod.ClassDtlModule)
    },
    {
        path : 'learning',
        loadChildren : () => import('./pages/learning/learning.module').then(mod => mod.LearningModule)
    },
    {
        path : 'quiz',
        loadChildren : () => import('./pages/quiz/quiz.module').then(mod => mod.QuizModule)
    },
    {
        path : 'exam',
        loadChildren : () => import('./pages/exam/exam.module').then(mod => mod.ExamModule)
    },
    {
        path : 'forum',
        loadChildren : () => import('./pages/forum/forum.module').then(mod => mod.ForumModule)
    },
    {
        path : '**',
        component : NotFoundComponent
    }
] 

@NgModule({
    imports : [
        RouterModule.forRoot(routes), ContentModule
    ],
    exports : [
        RouterModule
    ]
})
export class AppRouting {}