package com.realdolmen.erkoja.boxed.mappers;

import com.realdolmen.erkoja.boxed.domain.Cell;
import com.realdolmen.erkoja.boxed.domain.CellBlock;
import com.realdolmen.erkoja.boxed.domain.Crime;
import com.realdolmen.erkoja.boxed.domain.Job;
import com.realdolmen.erkoja.boxed.domain.Prisoner;
import com.realdolmen.erkoja.boxed.dtos.CellBlockDto;
import com.realdolmen.erkoja.boxed.dtos.CellDto;
import com.realdolmen.erkoja.boxed.dtos.CrimeDto;
import com.realdolmen.erkoja.boxed.dtos.JobDto;
import com.realdolmen.erkoja.boxed.dtos.PrisonerDto;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class CellMapper implements Function<Cell, CellDto> {

    @Override
    public CellDto apply(Cell cell) {
        CellDto dto = new CellDto(cell.getCellId(), cell.getCellNr(), cell.getSize(), cell.isIsolationCell());
        if (cell.getCellBlock() != null) {
            CellBlockMapper cbm = new CellBlockMapper();
            CellBlock cellBlock = cell.getCellBlock();
            CellBlockDto cbDto = cbm.apply(cellBlock);
            dto.setCellBlock(cbDto);
        }
        if (cell.getPrisonerList() != null) {
            List<Prisoner> prisonerList = cell.getPrisonerList();
            List<PrisonerDto> prisonerDtoList = new ArrayList<>();
            for (Prisoner p : prisonerList) {
                PrisonerDto pDto = new PrisonerDto(p.getId(), p.getName(), p.getIsolated(), p.getIsolationDuration(), p.getReleaseDate(), p.getJobDuration());
                if (p.getJob() != null) {
                    Job job = p.getJob();
                    pDto.setJob(new JobDto(job.getId(), job.getName(), job.getDuration()));
                }
                if (p.getCrimes() != null) {
                    CrimeMapper cm = new CrimeMapper();
                    List<Crime> crimeList = p.getCrimes();
                    List<CrimeDto> crimeDtoList = new ArrayList<>();
                    for (Crime c : crimeList) {
                        crimeDtoList.add(cm.apply(c));
                    }
                    pDto.setCrimes(crimeDtoList);
                }
                pDto.setCell(dto);
                prisonerDtoList.add(pDto);
            }
            dto.setPrisonerList(prisonerDtoList);
        }
        return dto;
    }

}
