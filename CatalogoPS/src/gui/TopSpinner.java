package gui;

import javax.swing.JLayeredPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class TopSpinner {
   private JLayeredPane layeredPane;
   private SpinnerModel model;

   public TopSpinner(JLayeredPane parent) {
      this.layeredPane = parent;
      String[] options = { "-", "Alfabéticamente", "Precio ascendente", "Precio descendente" };
      this.model = new SpinnerListModel(options);
      JSpinner spinner = new JSpinner(model);
      // scrollPane.setColumnHeaderView(spinner);

      spinner.setVisible(true);
      spinner.addChangeListener(new ChangeListener() {
         public void stateChanged(ChangeEvent e) {
            SpinnerModel modelAux = model;
         }
      });

      layeredPane.add(spinner);
   }
}
