package com.realdolmen.erkoja.boxed.mappers;

import com.realdolmen.erkoja.boxed.domain.Cell;
import com.realdolmen.erkoja.boxed.domain.CellBlock;
import com.realdolmen.erkoja.boxed.domain.Crime;
import com.realdolmen.erkoja.boxed.domain.Guard;
import com.realdolmen.erkoja.boxed.domain.Prisoner;
import com.realdolmen.erkoja.boxed.dtos.CellBlockDto;
import com.realdolmen.erkoja.boxed.dtos.CellDto;
import com.realdolmen.erkoja.boxed.dtos.CrimeDto;
import com.realdolmen.erkoja.boxed.dtos.GuardDto;
import com.realdolmen.erkoja.boxed.dtos.PrisonerDto;
import com.realdolmen.erkoja.boxed.facades.CellFacade;
import com.realdolmen.erkoja.boxed.services.CellService;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class CellBlockDTOMapper implements Function<CellBlockDto, CellBlock> {

    public CellBlockDTOMapper() {
    }

    @Override
    public CellBlock apply(CellBlockDto c) {
        CellBlock cellBlock = new CellBlock(c.getCellBlockId());
        if (c.getGuards() != null) {
            List<GuardDto> guardDTOList = c.getGuards();
            List<Guard> guardList = new ArrayList<>();
            for (GuardDto g : guardDTOList) {
                Guard guard = new Guard(g.getGrade());

                if (g.getId() != null) {
                    Integer id = g.getId();
                    guard.setId(id);
                }

                if (g.getName() != null) {
                    String name = g.getName();
                    guard.setName(name);
                }

                guard.setCellBlock(cellBlock);
                guardList.add(guard);
            }
            cellBlock.setGuards(guardList);
        }

        if (c.getCells() != null) {
            List<CellDto> cellDtos = c.getCells();
            List<Cell> cells = new ArrayList<>();
            for (CellDto ce : cellDtos) {
                Cell cell = new Cell(ce.getCellId(), ce.getCellNr(), ce.getSize(), ce.isIsolationCell());
                cell.setCellBlock(cellBlock);
                if (ce.getPrisonerList() != null) {
                    List<PrisonerDto> prisonerDTOList = ce.getPrisonerList();
                    List<Prisoner> prisonerList = new ArrayList<>();
                    for (PrisonerDto p : prisonerDTOList) {
                        Prisoner prisoner = new Prisoner();

                        if (p.getId() != null) {
                            Integer id = p.getId();
                            prisoner.setId(id);
                        }

                        if (p.getName() != null) {
                            String name = p.getName();
                            prisoner.setName(name);
                        }

                        if (p.getCrimes() != null) {
                            CrimeDTOMapper cm = new CrimeDTOMapper();
                            List<CrimeDto> crimeDtos = p.getCrimes();
                            List<Crime> crimes = new ArrayList<>();
                            for (CrimeDto cDto : crimeDtos) {
                                crimes.add(cm.apply(cDto));
                            }
                            prisoner.setCrimes(crimes);
                        }

                        if (p.getReleaseDate() != null) {
                            Integer release = p.getReleaseDate();
                            prisoner.setReleaseDate(release);
                        }
                        prisoner.setCell(cell);
                        prisonerList.add(prisoner);
                    }
                    cell.setPrisonerList(prisonerList);
                }
                cells.add(cell);
            }
            cellBlock.setCells(cells);
        }
        return cellBlock;
    }
}
