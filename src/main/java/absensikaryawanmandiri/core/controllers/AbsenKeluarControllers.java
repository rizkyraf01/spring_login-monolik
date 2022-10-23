package absensikaryawanmandiri.core.controllers;

import absensikaryawanmandiri.core.models.entity.absensikeluar_karyawan;
import absensikaryawanmandiri.core.models.entity.daftar_karyawan;
import absensikaryawanmandiri.core.models.repository.AbsensiKeluarKaryawanRepository;
import absensikaryawanmandiri.core.services.AbsensiKeluarKaryawanServices;
import absensikaryawanmandiri.core.services.DaftarKaryawanServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("")

public class AbsenKeluarControllers {

    @Autowired
    private AbsensiKeluarKaryawanServices absensiKeluarKaryawanServices;

    @Autowired
    private DaftarKaryawanServices daftarKaryawanServices;

    @Autowired
    private AbsensiKeluarKaryawanRepository absensiKeluarKaryawanRepository;

    @GetMapping("/dashboard/table-absen-keluar")
    public String absenoutlist(Model model) {
        model.addAttribute("daftarabsenkeluar", absensiKeluarKaryawanServices.findAll());
        return "pages/tables/absenkeluar-table";
    }

    @GetMapping("/addout/absen")
    public String addout(Model model) {
        model.addAttribute("addAbsensikeluar", new absensikeluar_karyawan());
        return "pages/forms/absen_keluar";
    }

    @PostMapping("/save/absen_keluar")
    public String saveout(@ModelAttribute("addAbsensikeluar") absensikeluar_karyawan addAbsensisKeluar, daftar_karyawan checkNipKaryawan, RedirectAttributes redirAttrs) {

        boolean checkNipAbsenKaryawan = absensiKeluarKaryawanServices.checkNipAbsen(addAbsensisKeluar.getNip());
        boolean checkNip = absensiKeluarKaryawanServices.checkNip(checkNipKaryawan.getNip());
        System.out.println(checkNipAbsenKaryawan);

        if (checkNip) {
            if (checkNipAbsenKaryawan) {
                redirAttrs.addFlashAttribute("Error", "Sudah Absen Hari ini, Tolong Absen Besok Lagi");
            } else {
                absensikeluar_karyawan absensikeluar_karyawans = absensiKeluarKaryawanServices.addAbsensiKeluar(addAbsensisKeluar);
                if (absensikeluar_karyawans != null) {
                    redirAttrs.addFlashAttribute("Success", "Absen Telah Berhasil");
                } else {
                    redirAttrs.addFlashAttribute("Error", "Gagal Absen Mohon Dicoba Lagi");
                }
            }
        } else {
            redirAttrs.addFlashAttribute("Error", "NIP Tidak Tersedia Mohon Hubungi Admin");
        }
        return "redirect:/addout/absen";
    }
}

