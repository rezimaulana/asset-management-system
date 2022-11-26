import { ClassHdrDataDto } from "./class-hdr.data.dto";

export class ClassHdrResDto{
    private _data : ClassHdrDataDto = new ClassHdrDataDto

    public get data(): ClassHdrDataDto {
        return this._data;
    }

    public set data(data: ClassHdrDataDto) {
        this._data = data;
    }

}