import { ClassHdrDataDto } from "./class-hdr.data.dto";

export class ClassHdrListResDto{
    private _data : ClassHdrDataDto[] = []

    public get data(): ClassHdrDataDto[] {
        return this._data;
    }

    public set data(data: ClassHdrDataDto[]) {
        this._data = data;
    }

}