package me.davidams789.ReportAms;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import me.davidams789.ReportAms.commands.Report;

public class Main extends JavaPlugin{
    
    public void onEnable(){
        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&',"&8&l[&5&lReportAms&8&l] &aEl plugin se activo correctamente"));
        registerCommands();
    }
    
    public void onDisable(){
        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&',"&8&l[&5&lReportAms&8&l] &cEl plugin ha sido desactivado"));
    }

    public void registerCommands(){
        getCommand("report").setExecutor(new Report());
    }
}
