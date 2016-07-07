/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasi.controller;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author dimmaryanto
 */
public class TableViewController {

    private final JTable table;
    private final DefaultTableModel model;
    private final TableRowSorter<TableModel> sorter;

    public TableViewController(JTable table) {
        this.table = table;
        this.model = (DefaultTableModel) table.getModel();
        this.sorter = new TableRowSorter<>(model);
        this.table.setRowSorter(sorter);
        clearData();
    }

    public DefaultTableModel getModel() {
        return model;
    }

    public TableRowSorter<TableModel> getSorter() {
        return sorter;
    }

    public void clearData() {
        this.model.getDataVector().removeAllElements();
        this.model.fireTableDataChanged();
    }

    public Integer getRowSelected() {
        return table.getSelectedRow();
    }

    public Boolean isSelected() {
        return getRowSelected() >= 0;
    }

}
