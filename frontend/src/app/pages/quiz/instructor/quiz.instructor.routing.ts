import { NgModule } from "@angular/core";
import { Routes } from "@angular/router";
import { RouterModule } from "@angular/router";

const routes : Routes = [
    {
        path : 'class-hdr/:id',
        loadChildren : () => import('./material/quiz-material.instructor.module').then(mod => mod.QuizMaterialModuleInstructor)
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

export class QuizRoutingInstructor{}