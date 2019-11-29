package es.adrianmmudarra.inventory.layout.sector;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import es.adrianmmudarra.inventory.R;
import es.adrianmmudarra.inventory.data.model.Sector;

public class SectorActivity extends AppCompatActivity implements SectorListView.OnSectorListViewListener{

    private SectorListView sectorListView;

    private SectorListPresenter sectorListPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sector);
        initialice();
    }

    private void initialice() {
        sectorListView = (SectorListView) getSupportFragmentManager().findFragmentByTag(SectorListView.TAG);
        if (sectorListView == null){
            sectorListView = SectorListView.newInstance(null);

            getSupportFragmentManager()
                    .beginTransaction()
                    .add(android.R.id.content,sectorListView,SectorListView.TAG)
                    .commit();
        }

        sectorListPresenter = new SectorListPresenter(sectorListView);
        sectorListView.setPresenter(sectorListPresenter);
    }

    @Override
    public void onAddEditSector(Sector sector) {

    }
}
