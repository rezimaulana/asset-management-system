import { NgModule } from "@angular/core";
import { Routes } from "@angular/router";
import { RouterModule } from "@angular/router";
import { ContentComponentSuperAdmin } from "src/app/components/content/super-admin/content.super-admin.component";
import { ClassHdrListComponentSuperAdmin } from "./list/class-hdr-list.super-admin.component";
import { ClassHdrInsertComponentSuperAdmin } from "./insert/class-hdr-insert.super-admin.component";
import { ClassHdrUpdateComponentSuperAdmin } from "./update/class-hdr-update.super-admin.component";

const routes : Routes = [
    {
        path : "",
        component : ContentComponentSuperAdmin,
        children : [
            {
                path: "",
                component : ClassHdrListComponentSuperAdmin
            },
            {
                path: "new",
                component : ClassHdrInsertComponentSuperAdmin
            },
            {
                path: "edit/:id",
                component : ClassHdrUpdateComponentSuperAdmin
            }
        ]
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

export class ClassHdrRoutingSuperAdmin{}