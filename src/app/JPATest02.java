package app;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Pelicula;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class JPATest02 extends JFrame {

	private JPanel contentPane;
	private JTextField txtCodigo;
	private JTextField txtSinopsis;
	private JTextField txtPelicula;
	private JTextField txtGenero;
	private JTextField txtEstreno;
	private JTextField txtActores;
	private JTextField txtCnombre;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JPATest02 frame = new JPATest02();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JPATest02() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 499, 367);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitle = new JLabel("CREAR PELICULA");
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblTitle.setBounds(10, 25, 276, 37);
		contentPane.add(lblTitle);
		
		JLabel lblCodigo = new JLabel("C\u00F3digo:");
		lblCodigo.setForeground(Color.WHITE);
		lblCodigo.setBounds(10, 62, 46, 14);
		contentPane.add(lblCodigo);
		
		JLabel lblNombre = new JLabel("Pel\u00EDcula:");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNombre.setBounds(10, 87, 89, 14);
		contentPane.add(lblNombre);
		
		txtCodigo = new JTextField();
		txtCodigo.setBackground(Color.WHITE);
		txtCodigo.setEditable(false);
		txtCodigo.setBounds(95, 59, -13, 20);
		contentPane.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		txtSinopsis = new JTextField();
		txtSinopsis.setBounds(95, 176, 259, 20);
		contentPane.add(txtSinopsis);
		txtSinopsis.setColumns(10);
		
		txtPelicula = new JTextField();
		txtPelicula.setBounds(95, 86, 259, 20);
		contentPane.add(txtPelicula);
		txtPelicula.setColumns(10);
		
		txtGenero = new JTextField();
		txtGenero.setBounds(95, 114, 259, 20);
		contentPane.add(txtGenero);
		txtGenero.setColumns(10);
		
		txtEstreno = new JTextField();
		txtEstreno.setBounds(95, 145, 259, 20);
		contentPane.add(txtEstreno);
		txtEstreno.setColumns(10);
		
		txtActores = new JTextField();
		txtActores.setBounds(95, 207, 259, 20);
		contentPane.add(txtActores);
		txtActores.setColumns(10);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 crearPelicula();
			}
		});
		btnRegistrar.setBounds(388, 58, 89, 23);
		contentPane.add(btnRegistrar);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listarActoresPorNombreDePelicula(txtCnombre.getText());
			}
		});
		btnConsultar.setBounds(265, 284, 89, 23);
		contentPane.add(btnConsultar);
		
		JLabel lblConsultarActoresPor = new JLabel("CONSULTAR ACTORES ");
		lblConsultarActoresPor.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblConsultarActoresPor.setBounds(10, 239, 367, 37);
		contentPane.add(lblConsultarActoresPor);
		
		txtCnombre = new JTextField();
		txtCnombre.setToolTipText("N");
		txtCnombre.setColumns(10);
		txtCnombre.setBounds(10, 285, 245, 20);
		contentPane.add(txtCnombre);
		
		JLabel lblGnero = new JLabel("G\u00E9nero:");
		lblGnero.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblGnero.setBounds(10, 115, 89, 14);
		contentPane.add(lblGnero);
		
		JLabel lblEstreno = new JLabel("Estreno:");
		lblEstreno.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblEstreno.setBounds(10, 145, 89, 14);
		contentPane.add(lblEstreno);
		
		JLabel lblSinopsis = new JLabel("Sinopsis:");
		lblSinopsis.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSinopsis.setBounds(10, 179, 89, 14);
		contentPane.add(lblSinopsis);
		
		JLabel lblActores = new JLabel("Actores:");
		lblActores.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblActores.setBounds(10, 208, 89, 14);
		contentPane.add(lblActores);
	}
	void crearPelicula() {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory
				("DAWI_CL1_CHAMORRO_VALDERRAMA_PIERO_ALEXIS");
		EntityManager em = fabrica.createEntityManager();
		
		Pelicula p = new Pelicula();
		p.setNompeli(txtPelicula.getText());
		p.setGenero(txtGenero.getText());
		p.setFestreno(txtEstreno.getText());
		p.setSinopsis(txtSinopsis.getText());
		p.setActores(txtActores.getText());
		
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
		
		em.close();
		fabrica.close();
	}
	
	void listarActoresPorNombreDePelicula(String nompeli) {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory
				("DAWI_CL1_CHAMORRO_VALDERRAMA_PIERO_ALEXIS");
		EntityManager em = fabrica.createEntityManager();
		
		TypedQuery<Pelicula>  listarActoresPorNombreDePelicula = em.createNamedQuery("findxNpeli", Pelicula.class); 
			listarActoresPorNombreDePelicula.setParameter("xnomp", nompeli);
		List<Pelicula> lista =  listarActoresPorNombreDePelicula.getResultList();
		
		for (Pelicula p : lista) {
			System.out.println("-------------------------------");
			System.out.println("PREGUNTA 3");
			System.out.println("-------------------------------");
			System.out.println("PELICULA: " + p.getNompeli());
			System.out.println("ACTORES: " +p.getActores() + ".");
		}
		
	}
	
}
