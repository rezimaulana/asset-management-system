import { NgModule } from "@angular/core";
import { ClassHdrRoutingSuperAdmin } from "./class-hdr.super-admin.routing";
import { ClassHdrInsertComponentSuperAdmin } from "./insert/class-hdr-insert.super-admin.component";
import { ClassHdrListComponentSuperAdmin } from "./list/class-hdr-list.super-admin.component";
import { ClassHdrUpdateComponentSuperAdmin } from "./update/class-hdr-update.super-admin.component";

@NgModule({
    declarations : [
        ClassHdrListComponentSuperAdmin, ClassHdrInsertComponentSuperAdmin, ClassHdrUpdateComponentSuperAdmin
    ],
    imports : [
        ClassHdrRoutingSuperAdmin
    ],
    exports : [
        ClassHdrListComponentSuperAdmin, ClassHdrInsertComponentSuperAdmin, ClassHdrUpdateComponentSuperAdmin
    ]
})

export class ClassHdrModuleSuperAdmin{}