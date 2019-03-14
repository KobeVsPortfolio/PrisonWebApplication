package com.realdolmen.erkoja.boxed.mappers;

import com.realdolmen.erkoja.boxed.domain.Cell;
import com.realdolmen.erkoja.boxed.domain.CellBlock;
import com.realdolmen.erkoja.boxed.domain.Crime;
import com.realdolmen.erkoja.boxed.domain.Guard;
import com.realdolmen.erkoja.boxed.domain.Job;
import com.realdolmen.erkoja.boxed.domain.Prisoner;
import com.realdolmen.erkoja.boxed.dtos.CellBlockDto;
import com.realdolmen.erkoja.boxed.dtos.CellDto;
import com.realdolmen.erkoja.boxed.dtos.CrimeDto;
import com.realdolmen.erkoja.boxed.dtos.GuardDto;
import com.realdolmen.erkoja.boxed.dtos.JobDto;
import com.realdolmen.erkoja.boxed.dtos.PrisonerDto;
import com.realdolmen.erkoja.boxed.facades.CellFacade;
import com.realdolmen.erkoja.boxed.services.CellService;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class CellBlockMapper implements Function<CellBlock, CellBlockDto> {

    public CellBlockMapper() {
    }

    @Override
    public CellBlockDto apply(CellBlock cellBlock) {
        CellBlockDto dto = new CellBlockDto(cellBlock.getCellBlockId());
        if (cellBlock.getGuards() != null) {
            List<Guard> guardList = cellBlock.getGuards();
            List<GuardDto> guardDtoList = new ArrayList<>();
            for (Guard g : guardList) {
                GuardDto guardDto = new GuardDto(g.getId(), g.getName(), g.getGrade());
                guardDto.setCellBlock(dto);
                guardDtoList.add(guardDto);
            }
            dto.setGuards(guardDtoList);
        }
        if (cellBlock.getCells() != null) {
            List<Cell> cells = cellBlock.getCells();
            List<CellDto> cellDtos = new ArrayList<>();
            for (Cell c : cells) {
                CellDto cellDto = new CellDto(c.getCellId(), c.getCellNr(), c.getSize(), c.isIsolationCell());
                cellDto.setCellBlock(dto);
                if (c.getPrisonerList() != null) {
                    List<Prisoner> prisonerList = c.getPrisonerList();
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
                            for (Crime crime : crimeList) {
                                crimeDtoList.add(cm.apply(crime));
                            }
                            pDto.setCrimes(crimeDtoList);
                        }
                        pDto.setCell(cellDto);
                        prisonerDtoList.add(pDto);
                    }
                    cellDto.setPrisonerList(prisonerDtoList);
                }
                cellDtos.add(cellDto);
            }
            dto.setCells(cellDtos);
        }
        return dto;
    }
}
