package me.davidams789.ReportAms.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Report implements CommandExecutor{

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)){
            return false;
        }

        Player p = (Player) sender;

        if(args.length == 0 || args.length == 1){
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8&l[&5&lReportAms&8&l] &cUso: /report <Nick> <Razon>"));
        }else{
            Player t = Bukkit.getPlayer(args[0]);

            String razon = "";
            int x = 0;
            for(String a : args){
                if(x == 0){
                    x++;
                    continue;
                }
                razon = razon + " " + a;
            }
            razon = razon.trim();

            if(t == null){
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8&l[&5&lReportAms&8&l] &cEste jugador no existe o no esta conectado!"));
            }else{
                for(Player staff : Bukkit.getServer().getOnlinePlayers()){
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8&l[&5&lReportAms&8&l] &aEl reporte fue enviado correctamente"));
                    if(staff.hasPermission("reportams.resive") || staff.isOp()){
                        t.sendMessage(ChatColor.translateAlternateColorCodes('&', "       &8&l[&5&lReportes&8&l]"));
                        t.sendMessage(ChatColor.translateAlternateColorCodes('&', "&eUsuario: &7" + p.getName()));
                        t.sendMessage(ChatColor.translateAlternateColorCodes('&', "&eUsuario reportado: &5" + t.getName()));
                        t.sendMessage(ChatColor.translateAlternateColorCodes('&', "&eRazon: &5" + razon));
                    }
                }
            }
        }

        return true;
    }
    
}
