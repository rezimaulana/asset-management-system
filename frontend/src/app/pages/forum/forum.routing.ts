import { NgModule } from "@angular/core";
import { Routes } from "@angular/router";
import { RouterModule } from "@angular/router";

const routes : Routes = [
    {
        path : 'instructor',
        loadChildren : () => import('./instructor/forum.instructor.module').then(mod => mod.ForumModuleInstructor)
    },
    {
        path : 'student',
        loadChildren : () => import('./student/forum.student.module').then(mod => mod.ForumModuleStudent)
    }
];

@NgModule({
    imports : [
        RouterModule.forChild(routes)
    ],
    exports : [
        RouterModule
    ]
})

export class ForumRouting{}